package ce306.shapoval.lab3;

/**
 * Інтерфейс Colorable для роботи з кольором світла лампи
 */
public interface Colorable {
    /**
     * Метод для встановлення кольору світла лампи за RGB-кодом
     * @param r Червона складова (0-255)
     * @param g Зелена складова (0-255)
     * @param b Синя складова (0-255)
     */
    void setColor(int r, int g, int b);
    
    /**
     * Метод для отримання поточного кольору світла лампи у вигляді рядка з RGB-кодом
     * @return Поточний колір у форматі RGB
     */
    String getColor();
}
