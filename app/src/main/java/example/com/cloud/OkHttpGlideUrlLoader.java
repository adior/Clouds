package example.com.cloud;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

import okhttp3.OkHttpClient;

public class OkHttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    private OkHttpClient okHttpClient;

    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(@NonNull GlideUrl glideUrl, int width, int height, @NonNull Options options) {
        return null;
    }

    @Override
    public boolean handles(@NonNull GlideUrl glideUrl) {
        return false;
    }

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        private OkHttpClient client;

        public Factory() {
        }

        public Factory(OkHttpClient client) {
            this.client = client;
        }

        private synchronized OkHttpClient getOkHttpClient() {
            if (client == null) {
                client = new OkHttpClient();
            }
            return client;
        }

        @NonNull
        @Override
        public ModelLoader<GlideUrl, InputStream> build(@NonNull MultiModelLoaderFactory multiFactory) {
            return null;
        }

        @Override
        public void teardown() {
        }
    }

    private OkHttpGlideUrlLoader(OkHttpClient client) {
        this.okHttpClient = client;
    }


    public DataFetcher<InputStream> getResourceFetcher(GlideUrl model, int width, int height) {
        return new OkHttpFetcher(okHttpClient, model) {
            @Override
            public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super InputStream> callback) {

            }

            @NonNull
            @Override
            public Class<InputStream> getDataClass() {
                return null;
            }

            @NonNull
            @Override
            public DataSource getDataSource() {
                return null;
            }
        };
    }
}
