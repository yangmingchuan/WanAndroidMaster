#指定压缩级别
  -optimizationpasses 5
  #不跳过非公共的库的类成员
  -dontskipnonpubliclibraryclassmembers
  #混淆时采用的算法
  -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
  #把混淆类中的方法名也混淆了
  -useuniqueclassmembernames
  #优化时允许访问并修改有修饰符的类和类的成员
  -allowaccessmodification
  #保留行号
  -keepattributes SourceFile,LineNumberTable
  #保持所有实现 Serializable 接口的类成员
  -keepclassmembers class * implements java.io.Serializable {
      static final long serialVersionUID;
      private static final java.io.ObjectStreamField[] serialPersistentFields;
      private void writeObject(java.io.ObjectOutputStream);
      private void readObject(java.io.ObjectInputStream);
      java.lang.Object writeReplace();
      java.lang.Object readResolve();
  }
#  google  阿里 混淆规则
  -keep class com.google.**
  -dontwarn com.google.**
  -dontwarn com.alipay.**
  -keep class com.alipay.** { *;}

  -dontusemixedcaseclassnames
  -dontskipnonpubliclibraryclasses
  -dontpreverify
  -verbose
  -dontshrink
  -ignorewarnings
  -keepattributes EnclosingMetho

  -keepattributes *Annotation*
  -keepattributes Signature
  -keep class com.lecloud.skin.** { *; }
  -keep class com.letv.pp.** { *; }
  -keep class cn.com.iresearch.mvideotracker.** { *; }
  -keep class com.letvcloud.sdk.** { *; }
  -keep class android.os.SystemProperties { *; }
  -keep class com.lecloud.common.** { *; }
  -keep class com.lecloud.download.** { *; }

  -keep public class * extends android.app.Fragment
  -keep public class * extends android.app.Activity
  -keep public class * extends android.app.Application
  -keep public class * extends android.app.Service
  -keep public class * extends android.content.BroadcastReceiver
  -keep public class * extends android.content.ContentProvider
  -keep public class * extends android.app.backup.BackupAgentHelper
  -keep public class * extends android.preference.Preference
  -keep public class * extends android.support.v4.**
  -keep public class com.android.vending.licensing.ILicensingService

  -keep class com.baidu.** { *; }
  -keep class vi.com.gdi.bgl.android.**{*;}
#  将实体类避免混淆
  -keep class cn.white.ymc.wanandroidmaster.data.** { *; }

  -dontwarn android.support.v4.**
  -dontwarn org.apache.commons.net.**
  -dontwarn com.tencent.**
  -keepclasseswithmembernames class * {
      native <methods>;
  }
  -keepclassmembers enum * {
      public static **[] values();
      public static ** valueOf(java.lang.String);
  }
  -keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
  }
  -keepclasseswithmembers class * {
      public <init>(android.content.Context);
  }

  -keepclassmembers class * extends android.app.Activity {
  public void *(android.view.View);
  }

# butterknife 混淆规则
-keep class butterknife.**
-dontwarn butterknife.internal.*
-keep class *$$ViewInjector
-keepclasseswithmembernames class * {
@butterknife. <fields>;
}
-keepclasseswithmembernames class * {
@butterknife. <methods>;
}

# okhttp Gson 混淆规则
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *;}
-keep class com.zhy.http.okhttp.*
-keep interface com.squareup.okhttp.**
-dontwarn okio.*
-keep class com.google.gson.* {*;}
-keep class com.google.gson.JsonObject { *; }
