package methodtest;

public class MyException extends Exception {
	private String message = null;
	
	public MyException() {
		super();
		message = "커스텀 예외 발생!!";
	}
	public String toString() {
		return message;
	}
}
