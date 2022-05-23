package arduinoCom;

public abstract class ComVar {
    static final byte EOM               = 0x01; // End Of Message delimiter
    static final byte DEVICE_NUM        = (byte) 0x10;

    public static class MOTOR {
        static final byte OFFSET        = 0x20;
        static final byte SET_SPEED     = 0x21;
        static final byte SET_DIRECTION = 0x22;
    }

    public static class SERVO {
        static final byte OFFSET        = 0x30;
        static final byte SET_ROTOR     = 0x31;
    }
}
