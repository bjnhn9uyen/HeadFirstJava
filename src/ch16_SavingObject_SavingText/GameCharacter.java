package ch16_SavingObject_SavingText;

import java.io.Serializable;

public class GameCharacter implements Serializable {

	// Each time an object is serialized, the object is ‘stamped’ with a version ID number ‘serialVersionUID’.
	// If the class has changed since the object was serialized, it could have a different serialVersionUID,
	// and deserialization will fail! But you can control this by putting a serial version ID in your class,
	// the serialVersionUID will remain the same and the JVM will think the class is compatible with the
	// serialized object, even though the class has actually changed
	private static final long serialVersionUID = -7661503363900955075L;

	private int power;
	private String type;
	private String[] weapons;

	// If you have an instance variable that can’t be saved because it isn’t serializable,
	// you can mark that variable with ‘transient’ keyword, the serialization process will skip right over it
	// When you deserialize an object, its transient instance variables will be brought back
	// as default primitive values or as null (for object references)
	private transient int health;

	public GameCharacter(int power, String type, String[] weapons, int health) {
		this.power = power;
		this.type = type;
		this.weapons = weapons;
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWeapons() {
		String weaponList = "";
		for (int i = 0; i < weapons.length; i++) {
			weaponList += weapons[i] + " | ";
		}
		return weaponList;
	}

	public int gethealth() {
		return health;
	}

	public int getPower() {
		return power;
	}

}
