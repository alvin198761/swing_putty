/******************************************************************************
 *
 * Copyright (c) 1999-2011 Cryptzone Group AB. All Rights Reserved.
 * 
 * This file contains Original Code and/or Modifications of Original Code as
 * defined in and that are subject to the MindTerm Public Source License,
 * Version 2.0, (the 'License'). You may not use this file except in compliance
 * with the License.
 * 
 * You should have received a copy of the MindTerm Public Source License
 * along with this software; see the file LICENSE.  If not, write to
 * Cryptzone Group AB, Drakegatan 7, SE-41250 Goteborg, SWEDEN
 *
 *****************************************************************************/

package com.mindbright.security.pkcs12;

import com.mindbright.asn1.ASN1Sequence;
import com.mindbright.asn1.ASN1Integer;
import com.mindbright.asn1.ASN1OctetString;

import com.mindbright.security.pkcs7.ContentInfo;

public final class PFX extends ASN1Sequence {

    public ASN1Integer version;
    public ContentInfo authSafe;
    public MacData     macData;

    public PFX() {
        version  = new ASN1Integer();
        authSafe = new ContentInfo();
        macData  = new MacData();
        addComponent(version);
        addComponent(authSafe);
        addOptional(macData);
    }

    public ASN1OctetString getDataContent() {
        return (ASN1OctetString)authSafe.content.getValue();
    }

}
