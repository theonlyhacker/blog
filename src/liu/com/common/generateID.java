package liu.com.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class generateID {
    public String getUUid() {
        UUID uuid = UUID.randomUUID();
        String uuidstr = uuid.toString().replace("-", "");
        return uuidstr;
    }

    public String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sdftime = sdf.format(date);
        return sdftime;
    }
}
