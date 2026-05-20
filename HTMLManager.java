import java.util.*;

public class HTMLManager {
	private Queue<HTMLTag> tags;

	public HTMLManager(Queue<HTMLTag> tags){
		if(tags == null){
			throw new IllegalArgumentException();
		}
		else{
			this.tags = tags;
		}
	}
}
