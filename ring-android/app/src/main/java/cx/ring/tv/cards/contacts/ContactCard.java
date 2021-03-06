/*
 *  Copyright (C) 2017 Savoir-faire Linux Inc.
 *
 *  Author: Loïc Siret <loic.siret@savoirfairelinux.com>
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
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package cx.ring.tv.cards.contacts;

import cx.ring.model.CallContact;
import cx.ring.tv.cards.Card;

public class ContactCard extends Card {
    CallContact mCallContact = null;
    private byte[] mPhoto = null;

    public ContactCard(CallContact pCallContact, Type type) {
        mCallContact = pCallContact;
        setId(pCallContact.getId());
        setTitle(pCallContact.getDisplayName());
        setDescription(pCallContact.getRingUsername());
        if (pCallContact.getPhoto() != null) {
            mPhoto = pCallContact.getPhoto();
        }
        setType(type);
    }

    public ContactCard(CallContact pCallContact) {
        mCallContact = pCallContact;
        setId(pCallContact.getId());
        setTitle(pCallContact.getDisplayName());
        setDescription(pCallContact.getRingUsername());
        if (pCallContact.getPhoto() != null) {
            mPhoto = pCallContact.getPhoto();
        }
        if (pCallContact.getDisplayName().equals(pCallContact.getRingUsername())) {
            setType(Type.CONTACT);
        } else {
            setType(Type.CONTACT_WITH_USERNAME);
        }
    }

    public CallContact getCallContact() {
        return mCallContact;
    }

    public byte[] getPhoto() {
        return mPhoto;
    }
}
