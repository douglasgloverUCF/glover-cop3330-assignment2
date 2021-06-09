package Sol31;

public class Formula {
    int getTargetRate(int intensity, int age, int rate)
    {
        return (((220 - age) - rate) * intensity / 100) + rate;
    }
}
