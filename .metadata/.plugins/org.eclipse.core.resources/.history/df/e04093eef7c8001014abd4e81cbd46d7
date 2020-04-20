
public class TemperatureTransformer{  
  
    public TemperatureTransformer(){ }  
  
    public Temperature convert(Temperature temp) throws Exception{  
       if(temp instanceof CelsiusTemperature) return convertToFahrenheit(temp);  
       else return convertToCelsius(temp);  
    }  
  
    private Temperature convertToFahrenheit(Temperature celsius) throws Exception{  
       FahrenheitTemperature f = new FahrenheitTemperature();  
       double cvalue = celsius.getValue();   
       double fvalue = 1.8*cvalue+f.getFREEZE(); // formulinha 1 :)  
       f.setValue(fvalue);  
       return f;  
    }  
  
    private Temperature convertToCelsius(Temperature fahrenheit) throws Exception{  
       CelsiusTemperature c = new CelsiusTemperature();  
       double fvalue = fahrenheit.getValue();   
       double cvalue = (5/9)*fvalue-5*fahrenheit.getFREEZE();// formulinha 2 ?!  
       c.setValue(cvalue);  
       return c;  
    }  
  
}  