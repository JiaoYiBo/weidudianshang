package com.example.aason.weidudianshang.app;

import android.app.Application;

import com.example.aason.weidudianshang.net.SpUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class QQApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5c089159b465f59767000066","小米",UMConfigure.DEVICE_TYPE_PHONE,"");
        UMConfigure.setLogEnabled(true);
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        DiskCacheConfig.Builder builder = DiskCacheConfig.newBuilder(this);
        builder.setBaseDirectoryPath(getCacheDir());
        DiskCacheConfig diskCacheConfig =builder.build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this,config);
        SpUtils.init(getApplicationContext());
    }
}
