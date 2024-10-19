import energy_saving_lamp as esl

def main():
    """
    Головна функція, яка демонструє роботу класу EnergySavingLamp.
    """

    # Створення об'єкта енергозберігаючої лампи
    energy_saving_lamp = esl.EnergySavingLamp(
        wattage=15.0,
        voltage=220.0,
        socket='E27',
        batteryCapacity=100.0,
        efficiency=0.85,  # 85% ефективність
        lifespan=10000,   # 10000 годин
        lampType='LED'    # Тип лампи
    )

    # Виведення початкових даних
    print("Енергозберігаюча лампа:")
    print(f"Потужність: {energy_saving_lamp.getWattage()} Вт")
    print(f"Напруга: {energy_saving_lamp.getVoltage()} В")
    print(f"Тип розетки: {energy_saving_lamp.getSocket()}")
    print(f"Ємність акумулятора: {energy_saving_lamp.getBatteryCapacity()} мАг")
    print(f"Ефективність: {energy_saving_lamp.getEfficiency() * 100}%")
    print(f"Термін служби: {energy_saving_lamp.getLifespan()} годин")
    print(f"Тип лампи: {energy_saving_lamp.getLampType()}")
    
    # Увімкнення лампи
    energy_saving_lamp.turnOn()

    # Симуляція розряду акумулятора
    discharge_amount = 20.0
    if energy_saving_lamp.unchargeBattery(discharge_amount):
        print(f"Акумулятор розряджений на {discharge_amount} мАг. Нова ємність: {energy_saving_lamp.getBatteryCapacity()} мАг")
    else:
        print("Не вдалося розрядити акумулятор.")

    # Симуляція зарядки акумулятора
    charge_amount = 10.0
    if energy_saving_lamp.chargeBattery(charge_amount):
        print(f"Акумулятор заряджений на {charge_amount} мАг. Нова ємність: {energy_saving_lamp.getBatteryCapacity()} мАг")
    else:
        print("Не вдалося зарядити акумулятор.")

    # Перевірка стану нагрівання
    if energy_saving_lamp.isWarmingUp():
        print("Лампа нагрівається...")
        energy_saving_lamp.updateBrightness()

    # Вимкнення лампи
    energy_saving_lamp.turnOff()

if __name__ == "__main__":
    main()
