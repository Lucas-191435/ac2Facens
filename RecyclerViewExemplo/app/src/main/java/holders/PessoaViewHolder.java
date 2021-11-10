package holders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewexemplo.R;

public class PessoaViewHolder extends RecyclerView.ViewHolder {
    public TextView txtNome;
    public ImageButton btnExcluir;

    public PessoaViewHolder(View view){
        super(view);
        txtNome = (TextView)view.findViewById(R.id.txtNome);
        btnExcluir = (ImageButton) view.findViewById(R.id.btnExcluir);
    }
}
