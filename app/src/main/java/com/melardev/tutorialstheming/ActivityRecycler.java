package com.melardev.tutorialstheming;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityRecycler extends AppCompatActivity {

    private RecyclerView recUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recUsers = (RecyclerView) findViewById(R.id.recUsers);

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("pizza", "3 Eur", R.drawable.pizza));
        products.add(new Product("hamburger", "1.5 Eur", R.drawable.hamburger));
        products.add(new Product("ice cream", "1 Eur", R.drawable.ice_cream));

        recUsers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recUsers.setAdapter(new RecProductsAdapter(this, products));
    }

    public class Product {
        String name;
        String price;
        int image;

        public Product(String name, String price, int image) {
            this.name = name;
            this.price = price;
            this.image = image;
        }
    }

    static class RecProductsAdapter extends RecyclerView.Adapter<RecProductsAdapter.ProducViewHolder> {

        private final Context context;
        private final ArrayList<Product> products;
        private int count = 0;

        RecProductsAdapter(Context context, ArrayList<Product> products) {
            this.context = context;
            this.products = products;
        }

        @Override
        public RecProductsAdapter.ProducViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            Log.d("counts", String.valueOf(++count));
            return new ProducViewHolder(inflater.inflate(R.layout.product_row, parent, false));
        }

        @Override
        public void onBindViewHolder(RecProductsAdapter.ProducViewHolder holder, int position) {
            Product product = products.get(position);

            holder.txtName.setText(product.name);
            holder.txtPrice.setText(product.price);
            holder.imgProduct.setImageResource(product.image);
        }

        @Override
        public int getItemCount() {
            return products.size();
        }

        class ProducViewHolder extends RecyclerView.ViewHolder {
            final TextView txtName;
            final TextView txtPrice;
            final ImageView imgProduct;

            ProducViewHolder(View itemView) {
                super(itemView);
                txtName = (TextView) itemView.findViewById(R.id.txtProduct);
                txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
                imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            }
        }
    }
}


