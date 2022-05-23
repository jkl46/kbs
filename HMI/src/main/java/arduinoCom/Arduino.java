package arduinoCom;

import com.fazecast.jSerialComm.SerialPort;

public class Arduino{
    private int baud = 9600;
    String portDescription;
    SerialPort sp;
    MessageListener messageListener;

    public Arduino(String portDescription) {
        this.portDescription = portDescription;

        sp = SerialPort.getCommPort(portDescription);
        sp.setComPortParameters(this.baud, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!sp.openPort()){
            throw new IllegalStateException(String.format("Unable to open port %s", this.portDescription));
        }
        messageListener = new MessageListener();
        sp.addDataListener(messageListener);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMotorSpeed(int n, int c){
        byte[] out = new byte[] { ComVar.MOTOR.SET_SPEED, (byte) ((byte) n | ComVar.DEVICE_NUM), (byte) c, ComVar.EOM};
        System.out.println();
        sp.writeBytes(out, out.length);
    }

    public void setMotorDirection(int n, int c){
        byte[] out = new byte[] { ComVar.MOTOR.SET_DIRECTION, (byte) n, (byte) c, ComVar.EOM};
        sp.writeBytes(out, out.length);
    }

    public void setServoRotor(int n, int c){
        byte[] out = new byte[] { ComVar.SERVO.SET_ROTOR, (byte) (n | ComVar.DEVICE_NUM), (byte) c, ComVar.EOM};
        sp.writeBytes(out, out.length);
    }

}

