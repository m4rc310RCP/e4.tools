/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 ******************************************************************************/
package org.eclipse.e4.tools.emf.ui.internal.common.component.dialogs;

import org.eclipse.e4.tools.emf.ui.common.IModelResource;
import org.eclipse.e4.tools.emf.ui.internal.Messages;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledItem;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuPackageImpl;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Shell;

public class HandledToolItemCommandSelectionDialog extends AbstractCommandSelectionDialog {
	private MHandledItem handler;

	public HandledToolItemCommandSelectionDialog(Shell parentShell, MHandledItem handler, IModelResource resource) {
		super(parentShell, resource);
		this.handler = handler;
	}

	@Override
	protected String getShellTitle() {
		return Messages.HandledToolItemCommandSelectionDialog_ShellTitle;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.HandledToolItemCommandSelectionDialog_DialogTitle;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.HandledToolItemCommandSelectionDialog_DialogMessage;
	}

	@Override
	protected Command createStoreCommand(EditingDomain editingDomain, MCommand command) {
		return SetCommand.create(editingDomain, handler, MenuPackageImpl.Literals.HANDLED_ITEM__COMMAND, command);
	}
}
