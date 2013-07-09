package retrofit.client;

import java.io.IOException;
import java.util.concurrent.Future;

import retrofit.RetrofitError;

/**
 * Created by koush on 6/2/13.
 */
abstract public class ClientBase implements Client {
  @Override public Future executeAsync(final Request request, Future future, final ResponseCallback callback) {
    try {
      callback.success(execute(request));
    }
    catch (IOException e) {
      callback.failure(RetrofitError.networkError(request.getUrl(), e));
    }
    return future;
  }

  @Override
  public boolean needsExecutor() {
    return true;
  }
}
