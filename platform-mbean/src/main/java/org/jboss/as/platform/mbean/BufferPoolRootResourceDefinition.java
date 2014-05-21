/*
 *
 *  JBoss, Home of Professional Open Source.
 *  Copyright 2013, Red Hat, Inc., and individual contributors
 *  as indicated by the @author tags. See the copyright.txt file in the
 *  distribution for a full listing of individual contributors.
 *
 *  This is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *
 *  This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this software; if not, write to the Free
 *  Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *  02110-1301 USA, or see the FSF site: http://www.fsf.org.
 * /
 */

package org.jboss.as.platform.mbean;

import org.jboss.as.controller.ReadResourceNameOperationStepHandler;
import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.registry.ManagementResourceRegistration;

/**
 * @author Tomaz Cerar (c) 2013 Red Hat Inc.
 */
class BufferPoolRootResourceDefinition extends SimpleResourceDefinition {
    static final BufferPoolRootResourceDefinition INSTANCE = new BufferPoolRootResourceDefinition();

    private BufferPoolRootResourceDefinition() {
        super(PlatformMBeanConstants.BUFFER_POOL_PATH,
                PlatformMBeanUtil.getResolver(PlatformMBeanConstants.BUFFER_POOL));
    }

    @Override
    public void registerAttributes(ManagementResourceRegistration resourceRegistration) {
        super.registerAttributes(resourceRegistration);
        resourceRegistration.registerReadOnlyAttribute(PlatformMBeanConstants.NAME, ReadResourceNameOperationStepHandler.INSTANCE);
    }

    @Override
    public void registerChildren(ManagementResourceRegistration resourceRegistration) {
        super.registerChildren(resourceRegistration);
        resourceRegistration.registerSubModel(BufferPoolResourceDefinition.INSTANCE);
    }
}

