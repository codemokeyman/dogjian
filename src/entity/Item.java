package entity;

public class Item {
	         private int    itemId;
		     private String  itemName;
		     private int    postId;
		     private String     state;
		     private String optionsId;
			public int getItemId() {
				return itemId;
			}
			public void setItemId(int itemId) {
				this.itemId = itemId;
			}
			public String getItemName() {
				return itemName;
			}
			public void setItemName(String itemName) {
				this.itemName = itemName;
			}
			public int getPostId() {
				return postId;
			}
			public void setPostId(int postId) {
				this.postId = postId;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getOptionsId() {
				return optionsId;
			}
			public void setOptionsId(String optionsId) {
				this.optionsId = optionsId;
			}
}
