package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private String kwota;
	private Double kwota_cal;
	private String procent;
	private Double czas;
	private Double rata; 
	
	private Double result;

	
	
	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public Double getKwota_cal() {
		return kwota_cal;
	}

	public void setKwota_cal(Double kwota_cal) {
		this.kwota_cal = kwota_cal;
	}

	public String getProcent() {
		return procent;
	}

	public void setProcent(String procent) {
		this.procent = procent;
	}

	public Double getCzas() {
		return czas;
	}

	public void setCzas(Double czas) {
		this.czas = czas;
	}

	public Double getRata() {
		return rata;
	}

	public void setRata(Double rata) {
		this.rata = rata;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public FacesContext getCtx() {
		return ctx;
	}

	public void setCtx(FacesContext ctx) {
		this.ctx = ctx;
	}

	@Inject
	FacesContext ctx;


	public boolean doTheMath() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double procent = Double.parseDouble(this.procent);
			procent = procent / 100;
			kwota_cal = kwota + (kwota * procent); 
			rata = kwota_cal / czas; 

			result = kwota;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}


}
