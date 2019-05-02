package example.com.cloud;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public abstract class MyGlideModule implements GlideModule {
    public void applyOptions(Context context, GlideBuilder builder) {
    }
    private OkHttpClient client=new OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .build();

    public void registerComponents(Context context, Glide glide , Registry registry) {
        OkHttpGlideUrlLoader.Factory factory = new OkHttpGlideUrlLoader.Factory(client);
        registry.replace(GlideUrl.class, InputStream.class,factory);
    }
}
