package com.telepathylabs.assignment.bestbuyplan.bean;

public class Feature {
    private String name;

	public Feature(){   }
    
    public Feature(String name){
        this.name = name;
    }
    
    public String getName() {
		return name;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feature other = (Feature) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " " + name + " ";
	}
	
    

	
	
}

