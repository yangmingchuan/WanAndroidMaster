package cn.white.ymc.wanandroidmaster.data;

/**
 * 返回值 外层数据
 *
 * @packageName: cn.white.ymc.wanandroidmaster.data
 * @fileName: BaseRes
 * @date: 2018/7/23  16:27
 * @author: ymc
 * @QQ:745612618
 */

public class BaseResp<T>{
    public T data;
    public int errorCode;
    public String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
