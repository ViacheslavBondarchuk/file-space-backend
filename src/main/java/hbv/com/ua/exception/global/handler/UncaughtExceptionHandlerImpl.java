package hbv.com.ua.exception.global.handler;

public class UncaughtExceptionHandlerImpl implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException( Thread thread, Throwable throwable ) {
		throwable.printStackTrace(  );
	}
}
