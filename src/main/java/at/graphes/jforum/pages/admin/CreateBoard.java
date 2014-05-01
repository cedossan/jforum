/*
 * Copyright (C) 2014 valerian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package at.graphes.jforum.pages.admin;

import at.graphes.jforum.dao.BoardDAO;
import at.graphes.jforum.entities.Board;
import at.graphes.jforum.pages.Index;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author valerian
 */
public class CreateBoard {
    
    @Property private Board newBoard;
    
    @Inject   private BoardDAO boardDAO;
    
    Object onSuccess() {
        
        boardDAO.save(newBoard);
        
        return Index.class;
    }
    
}