package com.melardev.tutorialstheming;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    private ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listViewProduct = (ListView) findViewById(R.id.listViewProduct);

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
        products.add(new Product("hamburger", "1.5 Eur", R.drawable.hamburger));
        products.add(new Product("ice cream", "1 Eur", R.drawable.ice_cream));

        listViewProduct.setAdapter(new ListProductAdapter(this, products));
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

    static class ListProductAdapter extends BaseAdapter {
        private final Context context;
        private final ArrayList<Product> products;

        public ListProductAdapter(Context context, ArrayList<Product> products) {
            this.context = context;
            this.products = products;
        }

        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            Product product = products.get(position);
            ListViewHolder holder;
            if (view == null) {
                view = inflater.inflate(R.layout.product_row, viewGroup, false);
                holder = new ListViewHolder();
                holder.txtName = (TextView) view.findViewById(R.id.txtProduct);
                holder.txtPrice = (TextView) view.findViewById(R.id.txtPrice);
                holder.imgProduct = (ImageView) view.findViewById(R.id.imgProduct);

                view.setTag(holder);
            } else {
                Log.d("ListView", "RECYCLED");
                holder = (ListViewHolder) view.getTag();
            }

            holder.txtName.setText(product.name);
            holder.txtPrice.setText(product.price);
            holder.imgProduct.setImageResource(product.image);
            return view;
        }

        static class ListViewHolder {
            TextView txtName;
            TextView txtPrice;
            ImageView imgProduct;
        }
    }
}
