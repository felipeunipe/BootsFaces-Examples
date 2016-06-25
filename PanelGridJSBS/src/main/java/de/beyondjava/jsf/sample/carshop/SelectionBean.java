package de.beyondjava.jsf.sample.carshop;

import java.util.List;

import javax.faces.bean.RequestScoped;

import de.beyondjava.angularFaces.components.puiSync.JSONUtilities;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SelectionBean {

	private List<Car> selectedCars;
    
    @Inject
    private CarPool carPool;

	@Inject
	private CarBean carBean;

	public CarBean getCarBean() {
		return carBean;
	}

	public void setCarBean(CarBean carBean) {
		this.carBean = carBean;
	}

	public List<Car> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Car> selectedCars) {
		this.selectedCars = selectedCars;
	}

	private String carAsJSon;

	public String getCarAsJSon() {
		return carAsJSon;
	}

	public void setCarAsJSon(String carAsJSon) {
		this.carAsJSon = carAsJSon;
	}

	public String showDetails() {
		int pos = carAsJSon.indexOf(",\"$$hashKey\"");
		if (pos > 0)
			carAsJSon = carAsJSon.substring(0, pos) + "}";

		Car car = (Car) JSONUtilities.readObjectFromJSONString(carAsJSon, Car.class);
		return getCarBean().showDetails(car);
	}

}
