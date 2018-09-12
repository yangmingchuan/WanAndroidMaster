package cn.white.ymc.wanandroidmaster.model;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import cn.white.ymc.wanandroidmaster.model.api.cookie.CookiesManager;
import cn.white.ymc.wanandroidmaster.model.api.HttpLoggingInterceptor;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * api retrofit 工具类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.model
 * @fileName: ApiStore
 * @date: 2018/7/23  16:30
 * @author: ymc
 * @QQ:745612618
 */

public class ApiStore {

    private static Retrofit retrofit;

    public static String baseUrl = ConstantUtil.BASE_URL;

    public static <T> T createApi(Class<T> service){
        return retrofit.create(service);
    }

    static {
        createProxy();
    }

    /**
     * 创建 retrofit 客户端
     */
    private static void createProxy() {

        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder();
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(new HttpLoggingInterceptor())
                .cookieJar(new CookiesManager());

        SSLSocketFactory sslSocketFactory = getSSLSocketFactory(new Buffer().writeUtf8(ConstantUtil.SSL_KEY).inputStream(),
                new Buffer().writeUtf8(ConstantUtil.MIDDLE_KEY).inputStream());
        if (sslSocketFactory != null) {
            //builder.sslSocketFactory(sslSocketFactory);
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
    }

    /**
     *  ssl 工厂类
     * @param certificates certificates
     * @return SSLSocketFactory
     */
    private static SSLSocketFactory getSSLSocketFactory(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try {
                    if (certificate != null){
                        certificate.close();
                    }
                } catch (IOException e) {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
