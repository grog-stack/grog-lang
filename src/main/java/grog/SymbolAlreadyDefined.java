package grog;

public class SymbolAlreadyDefined extends Exception {

	public SymbolAlreadyDefined() {
	}

	public SymbolAlreadyDefined(String message) {
		super(message);
	}

	public SymbolAlreadyDefined(Throwable cause) {
		super(cause);
	}

	public SymbolAlreadyDefined(String message, Throwable cause) {
		super(message, cause);
	}

	public SymbolAlreadyDefined(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
    
}
