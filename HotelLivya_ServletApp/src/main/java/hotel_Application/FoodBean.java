package hotel_Application;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FoodBean implements Serializable {
private String lollypop;
private Integer lollypopQty;
private String crispyChicken;
private Integer crispyChickenQty;
private String butterMasala;
private Integer butterMasalaQty;
private String hyderabadi;
private Integer hyderabadiQty;
private String iceCream;
private Integer iceCreamQty;
private String gulabJamun;
private Integer gulabJamunQty;
private final Double LollypopPrice=100.0;
private final Double CrispyChickenPrice=200.0;
private final Double ButterMasalaPrice=300.0;
private final Double HyderabadiPrice=300.0;
private final Double IceCreamPrice=50.0;
private final Double GulabJamunPrice=60.0;
private String sweetRoom;
private String deluxeSingle;
private String deluxeDouble;
private final Double sweetRoomPrice=3000.0;
private final Double deluxeSinglePrice=5000.0;
private final Double deluxeDoublePrice=7000.0;



public FoodBean() {
	super();
	// TODO Auto-generated constructor stub
}

public String getLollypop() {
	return lollypop;
}

public void setLollypop(String lollypop) {
	this.lollypop = lollypop;
}

public Integer getLollypopQty() {
	return lollypopQty;
}

public void setLollypopQty(Integer lollypopQty) {
	this.lollypopQty = lollypopQty;
}

public String getCrispyChicken() {
	return crispyChicken;
}

public void setCrispyChicken(String crispyChicken) {
	this.crispyChicken = crispyChicken;
}

public Integer getCrispyChickenQty() {
	return crispyChickenQty;
}

public void setCrispyChickenQty(Integer crispyChickenQty) {
	this.crispyChickenQty = crispyChickenQty;
}

public String getButterMasala() {
	return butterMasala;
}

public void setButterMasala(String butterMasala) {
	this.butterMasala = butterMasala;
}

public Integer getButterMasalaQty() {
	return butterMasalaQty;
}

public void setButterMasalaQty(Integer butterMasalaQty) {
	this.butterMasalaQty = butterMasalaQty;
}

public String getHyderabadi() {
	return hyderabadi;
}

public void setHyderabadi(String hyderabadi) {
	this.hyderabadi = hyderabadi;
}

public Integer getHyderabadiQty() {
	return hyderabadiQty;
}

public void setHyderabadiQty(Integer hyderabadiQty) {
	this.hyderabadiQty = hyderabadiQty;
}

public String getIceCream() {
	return iceCream;
}

public void setIceCream(String iceCream) {
	this.iceCream = iceCream;
}

public Integer getIceCreamQty() {
	return iceCreamQty;
}

public void setIceCreamQty(Integer iceCreamQty) {
	this.iceCreamQty = iceCreamQty;
}

public String getGulabJamun() {
	return gulabJamun;
}

public void setGulabJamun(String gulabJamun) {
	this.gulabJamun = gulabJamun;
}

public Integer getGulabJamunQty() {
	return gulabJamunQty;
}

public void setGulabJamunQty(Integer gulabJamunQty) {
	this.gulabJamunQty = gulabJamunQty;
}

public String getSweetRoom() {
	return sweetRoom;
}

public void setSweetRoom(String sweetRoom) {
	this.sweetRoom = sweetRoom;
}

public String getDeluxeSingle() {
	return deluxeSingle;
}

public void setDeluxeSingle(String deluxeSingle) {
	this.deluxeSingle = deluxeSingle;
}

public String getDeluxeDouble() {
	return deluxeDouble;
}

public void setDeluxeDouble(String deluxeDouble) {
	this.deluxeDouble = deluxeDouble;
}

public Double getLollypopPrice() {
	return LollypopPrice;
}

public Double getCrispyChickenPrice() {
	return CrispyChickenPrice;
}

public Double getButterMasalaPrice() {
	return ButterMasalaPrice;
}

public Double getHyderabadiPrice() {
	return HyderabadiPrice;
}

public Double getIceCreamPrice() {
	return IceCreamPrice;
}

public Double getGulabJamunPrice() {
	return GulabJamunPrice;
}

public Double getSweetRoomPrice() {
	return sweetRoomPrice;
}

public Double getDeluxeSinglePrice() {
	return deluxeSinglePrice;
}

public Double getDeluxeDoublePrice() {
	return deluxeDoublePrice;
}

@Override
public String toString() {
	return "FoodBean [lollypop=" + lollypop + ", lollypopQty=" + lollypopQty + ", crispyChicken=" + crispyChicken
			+ ", crispyChickenQty=" + crispyChickenQty + ", butterMasala=" + butterMasala + ", butterMasalaQty="
			+ butterMasalaQty + ", hyderabadi=" + hyderabadi + ", hyderabadiQty=" + hyderabadiQty + ", iceCream="
			+ iceCream + ", iceCreamQty=" + iceCreamQty + ", gulabJamun=" + gulabJamun + ", gulabJamunQty="
			+ gulabJamunQty + ", LollypopPrice=" + LollypopPrice + ", CrispyChickenPrice=" + CrispyChickenPrice
			+ ", ButterMasalaPrice=" + ButterMasalaPrice + ", HyderabadiPrice=" + HyderabadiPrice + ", IceCreamPrice="
			+ IceCreamPrice + ", GulabJamunPrice=" + GulabJamunPrice + ", sweetRoom=" + sweetRoom + ", deluxeSingle="
			+ deluxeSingle + ", deluxeDouble=" + deluxeDouble + ", sweetRoomPrice=" + sweetRoomPrice
			+ ", deluxeSinglePrice=" + deluxeSinglePrice + ", deluxeDoublePrice=" + deluxeDoublePrice + "]";
}




}
