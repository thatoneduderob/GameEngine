package engine;
import javax.swing.JFrame;

public class Game {
	private final JFrame window = new JFrame();
	private final ScreenFactory screenFactory;
	private final GameThread gameThread;
	private KeyboardListener keyboardListener;
	private final MousepadListener mousepadListener;

	public Game(int windowX, int windowY, String title) {
		window.setSize(windowX, windowY);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);

		screenFactory = new ScreenFactory(this);
		gameThread = new GameThread(this);
		keyboardListener = new KeyboardListener();
		mousepadListener = new MousepadListener();

		window.add(gameThread);
		window.addKeyListener(keyboardListener);
		window.addMouseListener(mousepadListener);

		new Thread(gameThread).start();
	}

	public KeyboardListener getKeyboardListener() {
		return keyboardListener;
	}

	public MousepadListener getMousepadListener() {
		return mousepadListener;
	}

	public ScreenFactory getScreenFactory() {
		return screenFactory;
	}

	public JFrame getWindow() {
		return window;
	}
}