import lamp

class EnergySavingLamp(lamp.Lamp):
    def __init__(self, wattage, voltage, socket, batteryCapacity, efficiency, lifespan, lampType):
        """
        Initializes the EnergySavingLamp object with additional properties

        Parameters:
        wattage (float): The wattage of the lamp
        voltage (float): The voltage of the lamp
        socket (str): The type of socket the lamp uses
        batteryCapacity (float): The capacity of the lamp's battery
        efficiency (float): Energy efficiency rating of the lamp
        lifespan (int): Lifespan of the lamp in hours
        lampType (str): Type of the lamp (CFL or LED)
        """
        super().__init__(wattage, voltage, socket, batteryCapacity)
        self._efficiency = efficiency  # Energy efficiency rating
        self._lifespan = lifespan        # Lifespan in hours
        self._lampType = lampType        # Type of lamp (CFL or LED)
        self._isWarmingUp = False        # Indicates if the lamp is warming up

    def getEfficiency(self):
        return self._efficiency

    def getLifespan(self):
        return self._lifespan

    def getLampType(self):
        return self._lampType

    def isWarmingUp(self):
        return self._isWarmingUp

    def turnOn(self):
        print("Energy-saving lamp is turned on.")
        self._isWarmingUp = True
        # Logic for warming up can be implemented here

    def turnOff(self):
        print("Energy-saving lamp is turned off.")
        self._isWarmingUp = False

    def updateBrightness(self):
        if self._isWarmingUp:
            # Logic to gradually increase brightness
            print("Lamp is warming up...")
            # Update brightness logic can be added here
