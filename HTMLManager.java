import java.util.*;

public class HTMLManager {
	private Queue<HTMLTag> tags;

	public HTMLManager(Queue<HTMLTag> tags) {
		this.tags = new LinkedList<>();
		if(tags == null) {
			throw new IllegalArgumentException();
		}
		else {
			while(!tags.isEmpty()){
				this.tags.add(tags.remove());
			}
		}
	}

	public Queue<HTMLTag> getTags() {
		return this.tags;
	}

	public void fixHTML() {
		Stack<HTMLTag> openTags = new Stack<>();
		Queue<HTMLTag> resultTags = new LinkedList<>();
		while(!tags.isEmpty()) {
			HTMLTag tag = tags.remove();
			if(tag.isOpening()) {
				openTags.push(tag);
				resultTags.add(tag);
			}
			else if(tag.isSelfClosing()) {
				resultTags.add(tag);
			}
			else if(tag.isClosing()) {
				if(!openTags.isEmpty()) {
					HTMLTag tempTag = openTags.pop();
					if(!tag.equals(tempTag)) {
						resultTags.add(tempTag.getMatching());
					}
					else {
						resultTags.add(tag);
					}
				}
			}
		}
		while(!openTags.isEmpty()) {
			resultTags.add(openTags.pop().getMatching());
		}
		tags = resultTags;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(HTMLTag tag : tags) {
			builder.append(tag.toString().trim());
		}
		return builder.toString();
	}
}
