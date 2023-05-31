package vacationPackage;

public class estimator {

	protected String destino;
	protected int totalViajantes;
	protected int diasDeViaje;
	
	//The base cost for a vacation package is $1000, and it should be applied to every  package.
	protected double costoTotal=0;
	protected double precioBase=1000;
	protected double descuento;
	
	  public estimator(){}
	  
	    public estimator(String destino, int totalViajantes,int diasDeViaje){
	        this.destino=destino;
	        this.totalViajantes=totalViajantes;
	        this.diasDeViaje=diasDeViaje;
	    }
private double validarNumeroPasajeros(){
	// The vacation package is not available for groups of more than 80 persons.    
	    	if(totalViajantes>80) {
	    		return -1 ;
	    	}
	    	
	//If the destination is a popular tourist spot, an additional cost based on the destination should be added to the base cost.
	
	if(destino.equals("Paris")) {
		int adicional=500;
		costoTotal=precioBase+adicional;
	}else if(destino.equals("New York")) {
		int adicional=600;
		costoTotal=precioBase+adicional;
	}
	
	// If the number of travelers is more than 4, but less than 10, a group discount of 10% should be applied to the total cost
	else if(4<totalViajantes|| totalViajantes<10) {
		descuento=0.10;
		costoTotal=costoTotal* descuento;
	} 
//If the number of travelers is more than 10, a group discount of 20% should be applied to the total cost.

	else if (totalViajantes>10) {
		descuento=0.20;
		costoTotal=costoTotal* descuento;
	}
	
//If the duration of the vacation is less than 7 days, a penalty fee of $200 should be  added to the total cost.
	else if (diasDeViaje<7) {
		costoTotal=costoTotal+200;
	}
// If the duration of the vacation is more than 30 days or the number of passengers is 2, $200 must be subtracted from the total cost, as it is a promotion policy.
	else if(diasDeViaje > 30 || totalViajantes==2) {
		costoTotal=costoTotal-200;
	}
	
	return costoTotal;
}
}


