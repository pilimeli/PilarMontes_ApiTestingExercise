package globant.api;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

/**
 * CGeneracion data
 */

public final class TransactionGenerator {
    private final static EasyRandom generator;

    static {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.excludeField(FieldPredicates.named("id"));
        parameters.stringLengthRange(3,10);

        generator = new EasyRandom(parameters);
    }

    private TransactionGenerator() {
    }

    public static EasyRandom generate() {
        return generator;
    }
}