/*
 *  Copyright (C) 2004-2013 Savoir-Faire Linux Inc.
 *
 *  Author: Alexandre Lision <alexandre.lision@savoirfairelinux.com>
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *  Additional permission under GNU GPL version 3 section 7:
 *
 *  If you modify this program, or any covered work, by linking or
 *  combining it with the OpenSSL project's OpenSSL library (or a
 *  modified version of that library), containing parts covered by the
 *  terms of the OpenSSL or SSLeay licenses, Savoir-Faire Linux Inc.
 *  grants you additional permission to convey the resulting work.
 *  Corresponding Source for a non-source form of such a combination
 *  shall include the source code for the parts of OpenSSL used as well
 *  as that of the covered work.
 */

package com.savoirfairelinux.sflphone.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.savoirfairelinux.sflphone.R;
import com.savoirfairelinux.sflphone.service.ISipService;
import com.savoirfairelinux.sflphone.views.ClearableEditText;

public class DialingFragment extends Fragment {

    private static final String TAG = DialingFragment.class.getSimpleName();
    public static final String ARG_SECTION_NUMBER = "section_number";


    ClearableEditText textField;
    // private AccountSelectionSpinner mAccountSelectionSpinner;

//    AccountSelectionAdapter mAdapter;
    private Callbacks mCallbacks = sDummyCallbacks;
//    private Spinner spinnerAccounts;

    

    /**
     * A dummy implementation of the {@link Callbacks} interface that does nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onCallDialed(String to) {
        }

        @Override
        public ISipService getService() {
            // TODO Auto-generated method stub
            return null;
        }
    };

    /**
     * The Activity calling this fragment has to implement this interface
     * 
     */
    public interface Callbacks {
        void onCallDialed(String account);

        public ISipService getService();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // mAdapter = new HistoryAdapter(getActivity(),new ArrayList<HashMap<String, String>>());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.frag_dialing, parent, false);

        

        textField = (ClearableEditText) inflatedView.findViewById(R.id.textField);
        ((ImageButton) inflatedView.findViewById(R.id.buttonCall)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = textField.getText().toString();
                if (to.contentEquals("")) {
                    Toast.makeText(getActivity(), "Enter a number", Toast.LENGTH_LONG).show();
                } else {
                    mCallbacks.onCallDialed(to);
                }
            }
        });

        ((Button) inflatedView.findViewById(R.id.alphabetic_keyboard)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                textField.setInputType(EditorInfo.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                InputMethodManager lManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                lManager.showSoftInput(textField.getEdit_text(), 0);
            }
        });

        ((Button) inflatedView.findViewById(R.id.numeric_keyboard)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                textField.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
                InputMethodManager lManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                lManager.showSoftInput(textField.getEdit_text(), 0);
            }
        });

        return inflatedView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

}