package arduinoCom;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortMessageListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageListener implements SerialPortMessageListener {
    private ArrayList<HashMap> messageBacklog = new ArrayList<HashMap>();

    private void handleMessage(byte[] message){
        HashMap<Byte, Character> msg = new HashMap<Byte, Character>();
        System.out.println(message);
        messageBacklog.add(msg);
    }

//    public boolean hasResponseTo(Byte getType){
//        for ( int i = 0; i < messageBacklog.size(); i++){
//            if (getType == messageBacklog.get(i).get(ComVar.RESPONSE.TO)){
//                return true;
//            }
//        }
//        return false;
//    }

//    public HashMap getResponseTo(Byte getType){
//        for ( int i = 0; i < messageBacklog.size(); i++){
//            if (messageBacklog.get(i).get(ComVar.RESPONSE.TO) == getType){
//                return messageBacklog.remove(i);
//            }
//        }
//        throw new IllegalStateException("No response");
//                return messageBacklog.remove(0);
//    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public byte[] getMessageDelimiter() {
        return new byte[]{(byte) ComVar.EOM};
    }

    @Override
    public boolean delimiterIndicatesEndOfMessage() {
        return true;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        handleMessage(event.getReceivedData());
    }
}
