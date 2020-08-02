package cc.oak.racing.condition;

import cc.oak.racing.Car;
import cc.oak.racing.converter.Converter;

public class CarForwardCondition<T> {
    Condition<T> condition;
    Converter<Car, T> carConverter;

    public CarForwardCondition(Condition<T> condition, Converter<Car, T> carConverter) {
        if (condition == null) {
            throw new IllegalArgumentException("condition is null!");
        }

        if (carConverter == null) {
            throw new IllegalArgumentException("carConverter is null!");
        }

        this.condition = condition;
        this.carConverter = carConverter;
    }

    public boolean isConvertedCarMeetCondition(Car car) {
        T convertedCar = carConverter.convert(car);
        return condition.isMeetCondition(convertedCar);
    }
}
