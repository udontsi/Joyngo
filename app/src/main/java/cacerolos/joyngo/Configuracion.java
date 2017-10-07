package cacerolos.joyngo;

import android.content.Context;
import android.content.SharedPreferences;

public class Configuracion {
    private final String SHARED_PREFS_FILE = "HMPrefs";
    private final String KEY_USER = "user";
    private Context mContext;

    public Configuracion(Context context){
        mContext = context;
    }
    private SharedPreferences getSettings(){
        return mContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
    }

    public String getUser(){
        return getSettings().getString(KEY_USER, null);
    }

    public void setUser(String email){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(KEY_USER, email );
        editor.commit();
    }

}

