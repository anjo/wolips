/* ====================================================================
 * 
 * The ObjectStyle Group Software License, Version 1.0 
 *
 * Copyright (c) 2004 The ObjectStyle Group 
 * and individual authors of the software.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        ObjectStyle Group (http://objectstyle.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "ObjectStyle Group" and "Cayenne" 
 *    must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact andrus@objectstyle.org.
 *
 * 5. Products derived from this software may not be called "ObjectStyle"
 *    nor may "ObjectStyle" appear in their names without prior written
 *    permission of the ObjectStyle Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE OBJECTSTYLE GROUP OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the ObjectStyle Group.  For more
 * information on the ObjectStyle Group, please see
 * <http://objectstyle.org/>.
 *
 */
package org.objectstyle.wolips.jdt.classpath;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.objectstyle.wolips.jdt.classpath.model.Framework;

/**
 * @author ulrich
 */
public class Container implements IClasspathContainer {

	/**
	 * The ID of the container.
	 */
	public static final String CONTAINER_IDENTITY = "org.objectstyle.wolips.ContainerInitializer";

	/**
	 * Comment for <code>DEFAULT_PATH</code>
	 */
	public static final String DEFAULT_PATH = CONTAINER_IDENTITY + "/10/1/JavaWebObjects/1/nil/1/nil/1/0/1/nil/10/1/JavaFoundation/1/nil/1/nil/1/0/1/nil/10/1/JavaXML/1/nil/1/nil/1/0/1/nil/10/1/JavaWOExtensions/1/nil/1/nil/1/0/1/nil/10/1/JavaEOAccess/1/nil/1/nil/1/0/1/nil/10/1/JavaEOControl/1/nil/1/nil/1/0/1/nil";
	/**
	 * Names of the standard frameworks.
	 */
	public static final String[] STANDARD_FRAMEWORK_NAMES = new String[] {
			"JavaWebObjects", "JavaFoundation", "JavaXML", "JavaWOExtensions",
			"JavaEOAccess", "JavaEOControl" };

	private ContainerEntries containerEntries = null;

	/**
	 * @param containerEntries
	 */
	public Container(ContainerEntries containerEntries) {
		super();
		this.containerEntries = containerEntries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.core.IClasspathContainer#getClasspathEntries()
	 */
	public IClasspathEntry[] getClasspathEntries() {
		return this.containerEntries.getEntries();
	}

	/**
	 * @see org.eclipse.jdt.core.IClasspathContainer#getDescription()
	 */
	public String getDescription() {
		return "WebObjects Frameworks";
	}

	/**
	 * @see org.eclipse.jdt.core.IClasspathContainer#getKind()
	 */
	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	/**
	 * @see org.eclipse.jdt.core.IClasspathContainer#getPath()
	 */
	public IPath getPath() {
		IPath path = new Path(Container.CONTAINER_IDENTITY);
		path = path.append(this.containerEntries.getPath());
		return path;
	}

	/**
	 * @param framework
	 * @return
	 */
	public boolean contains(Framework framework) {
		return this.containerEntries.contains(framework);
	}
}