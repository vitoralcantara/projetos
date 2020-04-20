
public class CelsiusTemperature implements Temperature{  
  
    private double value;  
  
    private final double FREEZE = 0;  
  
    private final double BOIL = 100;  
  
    private final double ZERO = -273;  
  
    public CelsiusTemperature(){ }  
  
    public double getValue(){   
       return value;  
    }  
  
    public void setValue(double value) throws Exception{  
       if(value < ZERO) throw new Exception("N‹o h‡ temperatura abaixo do zero absoluto");  
       else this.value = value;  
    }  
  
    public double getFREEZE(){ return FREEZE;}  
  
    public double getBOIL(){ return BOIL;}  
  
    public double getZERO(){ return ZERO;}  
  
    public String toString(){  
       return getValue()+" C";  
    }  
  
    public boolean equals(Object other){  
       if(other instanceof CelsiusTemperature)    
        return (((CelsiusTemperature) other).getValue() == getValue());  
       else return false;  
    }  
} 