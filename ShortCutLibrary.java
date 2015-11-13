import android.content.Context;
import android.content.Intent;
import pe.edu.idat.utpproject.R;

/*
*Syntaxis de Uso:  
new ShortCutLibrary(this).addShortcut(LoginActivity.class, getString(R.string.app_name));
*Permisos AndroidManifiest.xml
  <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
  <uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT" />
*/
public class ShortCutLibrary {
    private Context context;

    public ShortCutLibrary(Context context) {
        this.context = context;
    }
    public void addShortcut(Class<?> cls,String newName) {
        //CREAMOS UN INTENT Y APUNTAMOS A LA ACTIVIDAD PRINCIPAL "LoginActivity"
        Intent shortcutIntent = new Intent(context, cls);
        //AGREGAMOS LA ACCION
        shortcutIntent.setAction(Intent.ACTION_MAIN);

        //CREAMOS EL INTENT PARA EL ACCESO DIRECTO
        Intent addIntent = new Intent();
        //AGREGAMOS ACTIVIDAD, NOMBRE, ICONO
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, newName);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(context, R.mipmap.ic_launcher));
        //IMPORTATE: si el icono ya esta creado que no cree otro
        addIntent.putExtra("duplicate", false);
        //AGREGAMOS LA ACCION DEL INTENT
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        //ENVIAMOS LA PETICION DEL INTENT
        context.sendBroadcast(addIntent);
    }

    public void removeShortcut(Class<?> cls,String newName) {

        //ELIMINA ACCESO DIRECTO DEL HOME SCREEN
        Intent shortcutIntent = new Intent(context,cls);
        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, newName);
        addIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        context.sendBroadcast(addIntent);
    }
}
