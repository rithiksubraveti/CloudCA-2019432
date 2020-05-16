package ie.cct.CloudCA2019432;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmController {
	private ArrayList<Animal> animal;
	
	@GetMapping("welcome")
	public String welcome() {
		return "Welcome to my farm!!!";
	}
	public FarmController() {
		animal = new ArrayList<Animal>();
	}
	//End point 1 - adding of animals into the farm
	@PostMapping("farm-addanimal")
	public SuccessMessage addanimals(@RequestBody Animal animals) {
		animal.add(animals);
		return new SuccessMessage("Animal "+animals.getType()+","+" "+"of weight"+animals.getWeight()+" "+"and price "+animals.getPrice()+" "+"has been added succesully");
	}
	
	//End point 2- Calculating the average weight of animals in the farm
	@GetMapping("farm-averageweight")
	public SuccessMessage averageWeight() {
			Float weight= 0.0f;
			if(animal.size()==0) {
				throw new ExceptionMessage("Cannot calculate average as there are no animals in the farm");
			}
			for(Animal a: animal) {
				weight += a.getWeight();
			}
			weight = weight/animal.size();
			return new SuccessMessage("The average weight of animals in the farm is:"+" "+weight);
		}


	// End point 3 - calculating number of animals that can be sold based on weight constraint
	@GetMapping("farm-canbesold")
public List<Animal> canbeSold(){
	List<Animal> canbesold = new ArrayList<Animal>();
	for (Animal animals : animal) {
		if(animals.getType().equals("Cow") && animals.getWeight().compareTo(300.0f)>0) {
			canbesold.add(animals);
		}
		if(animals.getType().equals("Pig") && animals.getWeight().compareTo(100.0f)>0) {
			canbesold.add(animals);
		}
		if(animals.getType().equals("Chicken") && animals.getWeight().compareTo(5.0f)>0) {
			canbesold.add(animals);
		}
	}
	if(canbesold.size()==0) {
		throw new ExceptionMessage("There are no animals in the Farm right now!!!");
	}
	return canbesold;
	}
	
	/*	@GetMapping("farm-canbesold")
	public SuccessMessage canbeSold(){
			Float cows=0.0f;
			Float pigs=0.0f;
			Float chicken=0.0f;
		List<Animal> canbesold = new ArrayList<Animal>();
		for (Animal animals : animal) {
			if(animals.getType().equals("Cow") && animals.getWeight().compareTo(300.0f)>0) {
				canbesold.add(animals);
				cows++;
			}
			if(animals.getType().equals("Pig") && animals.getWeight().compareTo(100.0f)>0) {
				canbesold.add(animals);
				pigs++;
			}
			if(animals.getType().equals("Chicken") && animals.getWeight().compareTo(5.0f)>0) {
				canbesold.add(animals);
				chicken++;
			}
		}
		if(canbesold.size()==0) {
			throw new ExceptionMessage("There are no animals in the Farm right now!!!");
		}
		return new SuccessMessage("The number of animals that can be sold right now are (1)Cows-"+cows+" "+"(2)Pigs-"+pigs+" "+"and (3)Chickens-"+chicken);
		}*/

	//End point 4 -Calculating the value of the farm based on the weight constraints
@GetMapping("farm-value")
public Float farmValue() {
	List<Animal> farmvalue = new ArrayList<Animal>();
	Float price =0.0f;
	for (Animal animals: animal) {
		if(animals.getType().equals("Cow") && animals.getWeight().compareTo(300.0f)>0) {
			farmvalue.add(animals);
			price += animals.getPrice();
		} 
		if(animals.getType().equals("Pig") && animals.getWeight().compareTo(100.0f)>0) {
			farmvalue.add(animals);
			price += animals.getPrice();
		}
		if(animals.getType().equals("Chicken") && animals.getWeight().compareTo(5.0f)>0) {
			farmvalue.add(animals);
			price += animals.getPrice();
		}
	}
	if(farmvalue.size()==0) {
		throw new ExceptionMessage("There are no animals in the Farm right now!!!");
	}
	return price;
	}
@GetMapping("farm-stock")
 //End point 5 - Calculating farm value(Similar to above) but passing values through parameters
public String farmStock(@RequestParam(required = true)Float cowprice,@RequestParam(required = true)Float pigprice,@RequestParam(required = true)Float chickenprice) {
	return ("The value of the farm is:"+ " "+(cowprice+pigprice+chickenprice));
}
}

