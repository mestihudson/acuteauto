/**
 * 
 */
package com.acminds.acuteauto.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.acminds.acuteauto.persistence.dto.Make;
import com.acminds.acuteauto.persistence.dto.Model;
import com.acminds.acuteauto.persistence.dto.Style;
import com.acminds.acuteauto.persistence.dto.Vehicle;
import com.acminds.acuteauto.service.InventoryService;
import com.acminds.acuteauto.ui.BaseController;
import com.acminds.acuteauto.utils.Utils;
import com.acminds.acuteauto.utils.WebUtils;

/**
 * @author Mansur
 *
 */
@ManagedBean(name="invCtrl")
@RequestScoped
public class InventoryController extends BaseController {
	private InventoryService service = new InventoryService();
	private int makeId;
	private int modelId;
	private int styleId;
	private int bodyType;
	private int year;
	private int price;
	private int mileage;
	private List<Vehicle> cars;
	private List<Make> allMakes;
	private List<SelectItem> makes = new ArrayList<SelectItem>();
	private List<SelectItem> models = new ArrayList<SelectItem>();
	private List<SelectItem> styles = new ArrayList<SelectItem>();
	private List<SelectItem> years = new ArrayList<SelectItem>();
	private List<SelectItem> prices = new ArrayList<SelectItem>();
	
	public List<Vehicle> getCars() {
		return cars;
	}

	public void setCars(List<Vehicle> cars) {
		this.cars = cars;
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public int getBodyType() {
		return bodyType;
	}

	public void setBodyType(int bodyType) {
		this.bodyType = bodyType;
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public List<Make> getAllMakes() {
		if(Utils.isEmpty(allMakes)) {
			allMakes = service.getMakes(null);			
		}
		return allMakes;
	}
	
	public List<SelectItem> getMakes() {
		if(Utils.isEmpty(makes)) {
			makes.add(WebUtils.getDefaultSelectItem(false, null));
			for(Make m: getAllMakes()) {
				makes.add(new SelectItem(m.getMakeId(), m.getName()));
			}
		}
		return makes;
	}
	
	public List<SelectItem> getModels() {
		if(makeId==0)
			return models;
		for(Make m: getAllMakes()) {
			if(makeId == m.getMakeId()) {
				models.add(WebUtils.getDefaultSelectItem(false, null));
				for(Model md:m.getModels())
					models.add(new SelectItem(md.getModelId(), md.getName()));
			}
		}
		return models;
	}
	
	public List<SelectItem> getStyles() {
		if(modelId==0)
			return styles;
		for(Make m: getAllMakes()) {
			if(makeId==m.getMakeId()) {
				styles.add(WebUtils.getDefaultSelectItem(false, null));
				for(Model md:m.getModels()) {
					if(modelId==md.getModelId()) {
						for(Style st:md.getStyles())
							styles.add(new SelectItem(st.getStyleId(), st.getName()));
					}
				}
			}
		}
		return styles;
	}
	
	public List<SelectItem> getYears() {
		if(Utils.isEmpty(years)) {
			years.add(WebUtils.getDefaultSelectItem(true, null));
			for(int i= 2012; i>1991; i--)
				years.add(new SelectItem(i, String.valueOf(i)));
		}
		return years;
	}
	
	public List<SelectItem> getPrices() {
		if(Utils.isEmpty(prices)) {
			prices.add(WebUtils.getDefaultSelectItem(false, "No Max"));	
			for(int i= 3000; i<=15000; i=i+3000) {
				prices.add(new SelectItem(i, String.valueOf(i)));
			}
			for(int i= 20000; i<=50000; i=i+5000) {
				prices.add(new SelectItem(i, String.valueOf(i)));
			}
		}
		return prices;
	}
	/***************************
	 ********PUB METHODS******** 
	 ***************************/

	public String searchCars() {
		cars = service.getCars(makeId, modelId, styleId, year, price, mileage, bodyType);
		return null;
	}
	
	
	
	
}
