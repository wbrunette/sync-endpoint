/*
 * Copyright (C) 2011 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.aggregate.client.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.opendatakit.aggregate.constants.common.RowOrCol;
import org.opendatakit.aggregate.constants.common.Visibility;

public class ColumnFilter extends Filter implements Serializable {

  /**
   * Id for Serialization
   */
  private static final long serialVersionUID = -1045936241685471645L;

  private List<ColumnFilterHeader> columns;
  private Visibility kr;

  public ColumnFilter() {
    super();
  }

  public ColumnFilter(Visibility keepRemove, List<ColumnFilterHeader> columns, Long ordinal) {
    super(RowOrCol.COLUMN, ordinal);
    this.kr = keepRemove;
    this.columns = columns;
  }

  /**
   * This constructor should only be used by the server
   * 
   * @param uri
   */
  public ColumnFilter(String uri) {
    super(uri);
    this.columns = new ArrayList<ColumnFilterHeader>();
  }
  
  public Visibility getVisibility() {
    return kr;
  }

  public void setVisibility(Visibility kr) {
    this.kr = kr;
  }

  public List<ColumnFilterHeader> getColumnFilterHeaders() {
    return columns;
  }

  public void setColumnFilterHeaders(List<ColumnFilterHeader> columns) {
    this.columns = columns;
  }

  public void addColumnFilterHeader(ColumnFilterHeader column) {
    this.columns.add(column);
  }
  
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ColumnFilter)) {
      return false;
    }
    
    if(!super.equals(obj)) {
      return false;
    }
    
    ColumnFilter other = (ColumnFilter) obj;
    return (kr == null ? (other.kr == null) : (kr.equals(other.kr)))
        && (columns == null ? (other.columns == null) : (columns.equals(other.columns)));
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    int hashCode = 11;
    if (kr != null)
      hashCode += kr.hashCode();
    if(columns != null)
      hashCode += columns.hashCode();
    return hashCode;
  }
}