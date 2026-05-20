import java.util.*;

public class HTMLManager {
	private Queue<HTMLTag> tags;

	public HTMLManager(Queue<HTMLTag> tags) {
		if(tags == null) {
			throw new IllegalArgumentException();
		}
		else {
			this.tags = tags;
		}
	}

	public Queue<HTMLTag> getTags() {
		return this.tags;
	}
}
