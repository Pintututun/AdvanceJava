package playerDetails;

import java.io.InputStream;

public class PlayerBean {
private String id;
private String name;
private InputStream img;

public PlayerBean() {
	super();
	// TODO Auto-generated constructor stub
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public InputStream getImg() {
	return img;
}
public void setImg(InputStream img) {
	this.img = img;
}

}
