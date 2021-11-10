package adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexemplo.R;

import java.util.ArrayList;

import fakedataset.PessoaDataSetFake;
import holders.PessoaViewHolder;
import models.PessoaModel;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaViewHolder> {
    private final ArrayList<PessoaModel> pessoas;

    public PessoaAdapter(ArrayList<PessoaModel> pessoas){
        this.pessoas = pessoas;
    }

    @NonNull
    @Override
    public PessoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PessoaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_pessoa,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PessoaViewHolder holder, int position) {
        holder.txtNome.setText(pessoas.get(position).getCodigo() + " - " + pessoas.get(position).getNome());
        holder.btnExcluir.setOnClickListener(view -> removerItem(position));
    }

    private void removerItem(int position){
        pessoas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,pessoas.size());
    }
    public void adicionarItem(PessoaModel pessoa){
        PessoaDataSetFake.addItem(pessoa);
        notifyItemInserted(getItemCount());
    }

    @Override
    public int getItemCount() {
        return pessoas != null ? pessoas.size() : 0;
    }
}
