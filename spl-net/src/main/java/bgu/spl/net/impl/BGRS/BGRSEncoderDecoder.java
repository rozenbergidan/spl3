package bgu.spl.net.impl.BGRS;

import bgu.spl.net.api.MessageEncoderDecoder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * there are 4 different decodes:
 * LOGOUT + MYCOURSE 1
 * ADMINREG+STUDENTREG+LOGIN 2
 * COURSEREG+KDAMCHECK+COURSESTAT+ISREGISTER+UNREGISTER 3
 * STUDENTSTAT 4
 */
public class BGRSEncoderDecoder implements MessageEncoderDecoder<String> {

    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int len = 0;

    private String decodedMassege;


    @Override
    public String decodeNextByte(byte nextByte) {
        if(len==2){
            String result = new String(bytes, 0, len, StandardCharsets.UTF_8);
            if(result.equals("1") || result.equals("2") || result.equals("3")){
                return decoded1(???);
            }else if(result.equals("4") || result.equals("11")){
                return decoded2(???);
            }else if(result.equals("5") || result.equals("6") || result.equals("7") || result.equals("9") || result.equals("10")){
                return decoded3(???);
            }else if(result.equals("8")){
                return decoded4(???);
            }
        }
        pushByte(nextByte);
        return null;
    }

    /**
     * LOGOUT + MYCOURSE
     * @return
     */
    private String decoded1(????){

    }
    /**
     * ADMINREG+STUDENTREG+LOGIN
     * @return
     */
    private String decoded2(????){

    }
    /**
     * COURSEREG+KDAMCHECK+COURSESTAT+ISREGISTER+UNREGISTER
     * @return
     */
    private String decoded3(????){

    }
    /**
     * STUDENTSTAT
     * @return
     */
    private String decoded4(????){

    }
    @Override
    public byte[] encode(String message) {
        return new byte[0];
    }

    public short bytesToShort(byte[] byteArr) {
        short result = (short) ((byteArr[0] & 0xff) << 8);
        result += (short) (byteArr[1] & 0xff);
        return result;
    }

    private void bytesToString(){
    String result = new String(bytes, 0, len, StandardCharsets.UTF_8);
    len =0;
    }

    private void pushByte(byte nextByte) {
        if (len >= bytes.length) {
            bytes = Arrays.copyOf(bytes, len * 2);
        }

        bytes[len++] = nextByte;
    }
}
