package day07Prac.memo;

public class Memo {
	private String memoId;
	private String content;
	
	public Memo() {

	}

	public Memo(String memoId, String content) {
		this.memoId = memoId;
		this.content = content;
	}

	public String getMemoId() {
		return memoId;
	}

	public void setMemoId(String memoId) {
		this.memoId = memoId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Memo [memoId=" + memoId + ", content=" + content + "]";
	}
	
	
	
}
