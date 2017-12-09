package uit.dev.demomvp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uit.dev.demomvp.Model.User;
import uit.dev.demomvp.R;

/**
 * Created by Administrator on 09/12/2017.
 */

public class LoginAdapter extends BaseAdapter{
    ArrayList<User> arrayUser;
    private Context context;

    public LoginAdapter(Context context,ArrayList<User> arrayList) {
        this.context = context;
        this.arrayUser = arrayList;
    }

    @Override
    public int getCount() {
        return arrayUser.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        TextView tvEmail;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        User user = arrayUser.get(position);
        ViewHolder viewHolder;
        if (convertView == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.item_login,parent,false);
            viewHolder  = new ViewHolder();
            viewHolder.tvEmail = (TextView) v.findViewById(R.id.tvEmail);

            viewHolder.tvEmail.setText(user.getEmail());
            v.setTag(viewHolder);
        }
        else
        {
            v = convertView;
            viewHolder = (ViewHolder) v.getTag();
            viewHolder.tvEmail.setText(user.getEmail());
            v.setTag(viewHolder);
        }

        return v;

    }
}
