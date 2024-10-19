class Lamp:
    def __init__(self, wattage, voltage, socket, batteryCapacity):
        """
        Initializes the Lamp object with wattage, voltage, socket type and battery capacity
        
        Parameters:
        wattage (float): The wattage of the lamp
        voltage (float): The voltage of the lamp
        socket (str): The type of socket the lamp uses
        batteryCapacity (float): The capacity of the lamp's battery
        """
        self._wattage = wattage
        self._voltage = voltage
        self._socket = socket
        self._batteryCapacity = batteryCapacity

    def getWattage(self):
        return self._wattage
    
    def getVoltage(self):
        return self._voltage
    
    def getSocket(self):
        return self._socket
    
    def getBatteryCapacity(self):
        return self._batteryCapacity
    
    def setWattage(self, wattage):
        self._wattage = wattage
    
    def setVoltage(self, voltage):
        self._voltage = voltage
    
    def setSocket(self, socket):
        self._socket = socket
    
    def setBatteryCapacity(self, batteryCapacity):
        self._batteryCapacity = batteryCapacity

    def unchargeBattery(self, amount):
        """
        Decreases the battery capacity of the lamp by the given amount
        
        Parameters:
        amount (float): The amount to decrease the battery capacity by
        
        Returns:
        bool: True if the battery capacity was decreased, False otherwise
        """
        if self._batteryCapacity > amount:
            self._batteryCapacity -= amount
            return True
        else:
            return False
    
    def chargeBattery(self, amount):
        """
        Increases the battery capacity of the lamp by the given amount
        
        Parameters:
        amount (float): The amount to increase the battery capacity by
        
        Returns:
        bool: True if the battery capacity was increased, False otherwise
        """
        if self._batteryCapacity < amount:
            return False
        else:
            self._batteryCapacity -= amount
            return True

