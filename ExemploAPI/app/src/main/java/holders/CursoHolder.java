package holders;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.exemploapi.R;

public class CursoHolder extends RecyclerView.ViewHolder {
    public TextView txtNome;
    public TextView txtEmail;

    public CursoHolder(View view){
        super(view);
        txtEmail = (TextView)view.findViewById(R.id.txtEmail);
        txtNome = (TextView)view.findViewById(R.id.txtNome);


    }
}
